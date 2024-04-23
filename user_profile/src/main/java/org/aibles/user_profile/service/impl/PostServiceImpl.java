package org.aibles.user_profile.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.PostUpdateRequest;
import org.aibles.user_profile.dto.response.PostResponse;
import org.aibles.user_profile.entity.Post;
import org.aibles.user_profile.exception.PostIdNotFoundException;
import org.aibles.user_profile.exception.TitleAlreadyExistedException;
import org.aibles.user_profile.exception.UserProfileIdNotInThePostException;
import org.aibles.user_profile.filter.GenericSpecification;
import org.aibles.user_profile.repository.PostRepository;
import org.aibles.user_profile.service.PostService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository repository;

  @Override
  @Transactional
  public PostResponse create(String userProfileId, PostCreateRequest request) {
    log.info("(create)userProfileId: {}request: {}", userProfileId, request);
    validateTitle(request.getTitle());
    return PostResponse.from(
        repository.save(
            Post.of(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getCategory(),
                userProfileId
            )
        )
    );
  }

  @Override
  @Transactional
  public PostResponse getById(String id) {
    log.info("(getById)id: {}", id);
    var post = repository
        .findById(id)
        .orElseThrow(() -> {
          log.error("(getById)id: {}", id);
          throw new PostIdNotFoundException(id);
        });
    return PostResponse.from(post);
  }

  @Override
  @Transactional
  public List<PostResponse> getAll() {
    log.info("(getAll)");
    return PostResponse.from(repository.findAll());
  }

  @Override
  @Transactional
  public PostResponse updateById(String id, String userProfileId, PostUpdateRequest request) {
    log.info("(updateById)id: {}, userProfileId: {} request: {}", id, userProfileId, request);
    validateTitle(request.getTitle());
    var post = repository
        .findById(id)
        .orElseThrow(() -> {
          log.error("(getById)id: {}", id);
          throw new PostIdNotFoundException(id);
        });
    post.setTitle(request.getTitle());
    post.setContent(request.getContent());
    post.setAuthor(request.getAuthor());
    post.setCategory(request.getCategory());
    post.setUserProfileId(userProfileId);
    return PostResponse.from(repository.save(post));
  }

  @Override
  @Transactional
  public void deleteById(String id) {
    log.info("(deleteById)id: {}", id);
    repository
        .findById(id)
        .orElseThrow(() -> {
          log.error("(deleteById)id: {}", id);
          throw new PostIdNotFoundException(id);
        });
    repository.deleteById(id);
  }

  @Override
  public void existsByUserProfileIdAndId(String userProfileId, String id) {
    log.info("(existsByUserProfileId)userProfileId: {}, id: {}", userProfileId, id);
    if(!repository.existsByUserProfileIdAndId(userProfileId, id)) {
      log.error("(existsByUserProfileId)userProfileId: {}, id: {}", userProfileId, id);
      throw new UserProfileIdNotInThePostException(userProfileId, id);
    }
  }

  @Override
  @Transactional
  public void deleteAllByUserProfileId(String userProfileId) {
    log.info("(deleteAllByUserProfileId)userProfileId: {}", userProfileId);
    repository.deleteAllByUserProfileId(userProfileId);
  }

  @Override
  @Transactional
  public List<Post> findAllByUserProfileId(String userProfileId) {
    log.info("(findAllByUserProfileId)userProfileId: {}", userProfileId);
    return repository.findAllByUserProfileId(userProfileId);
  }

  @Override
  @Transactional
  public List<Post> findByCriteria(Map<String, String> paramsSearch) {
    log.info("(findByCriteria)paramsSearch: {}", paramsSearch);
    List<Specification> specs = paramsSearch.entrySet().stream()
        .map(entry -> new GenericSpecification<>(entry.getKey(), entry.getValue()))
        .collect(Collectors.toList());

    Specification combinedSpec = specs.stream()
        .reduce(Specification::and)
        .orElse(null);

    return repository.findAll(combinedSpec);
  }

  private void validateTitle(String title) {
    log.info("(validateTitle)title: {}", title);
    if(repository.existsByTitle(title)) {
      log.error("(validateTitle)title: {}", title);
      throw new TitleAlreadyExistedException(title);
    }
  }
}
