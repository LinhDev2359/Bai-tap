package org.aibles.user_profile.configuration;

import java.util.Random;
import org.aibles.user_profile.error_handle.AuthenticationErrorHandle;
import org.aibles.user_profile.facade.AuthFacadeService;
import org.aibles.user_profile.facade.CommentFacadeService;
import org.aibles.user_profile.facade.ImageFacadeService;
import org.aibles.user_profile.facade.PostFacadeService;
import org.aibles.user_profile.facade.ReactionFacadeService;
import org.aibles.user_profile.facade.UserProfileFacadeService;
import org.aibles.user_profile.facade.impl.AuthFacadeServiceImpl;
import org.aibles.user_profile.facade.impl.CommentFacadeServiceImpl;
import org.aibles.user_profile.facade.impl.ImageFacadeServiceImpl;
import org.aibles.user_profile.facade.impl.PostFacadeServiceImpl;
import org.aibles.user_profile.facade.impl.ReactionFacadeServiceImpl;
import org.aibles.user_profile.facade.impl.UserProfileFacadeServiceImpl;
import org.aibles.user_profile.repository.CommentRepository;
import org.aibles.user_profile.repository.ImageRepository;
import org.aibles.user_profile.repository.PostRepository;
import org.aibles.user_profile.repository.ReactionRepository;
import org.aibles.user_profile.repository.UserProfileRepository;
import org.aibles.user_profile.service.AuthTokenService;
import org.aibles.user_profile.service.CommentService;
import org.aibles.user_profile.service.EmailService;
import org.aibles.user_profile.service.ImageService;
import org.aibles.user_profile.service.OtpService;
import org.aibles.user_profile.service.PostService;
import org.aibles.user_profile.service.ReactionService;
import org.aibles.user_profile.service.UserProfileService;
import org.aibles.user_profile.service.impl.AuthTokenServiceImpl;
import org.aibles.user_profile.service.impl.CommentServiceImpl;
import org.aibles.user_profile.service.impl.ImageServiceImpl;
import org.aibles.user_profile.service.impl.PostServiceImpl;
import org.aibles.user_profile.service.impl.ReactionServiceImpl;
import org.aibles.user_profile.service.impl.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.user_profile.repository"})
@ComponentScan(basePackages = {"org.aibles.user_profile.repository"})
@EnableJpaAuditing
public class UserProfileConfiguration {

  @Value("${application.authentication.access_token.jwt_secret:xxx}")
  private String accessTokenJwtSecret;

  @Value("${application.authentication.access_token.life_time}")
  private Long accessTokenLifeTime;

  @Value("${application.authentication.refresh_token.jwt_secret:xxx}")
  private String refreshTokenJwtSecret;

  @Value("${application.authentication.refresh_token.life_time}")
  private Long refreshTokenLifeTime;

  @Bean
  public UserProfileService userProfileService(UserProfileRepository repository) {
    return new UserProfileServiceImpl(repository);
  }

  @Bean
  public PostService postService(PostRepository repository) {
    return new PostServiceImpl(repository);
  }

  @Bean
  public ImageService imageService(ImageRepository repository) {
    return new ImageServiceImpl(repository);
  }

  @Bean
  public PostFacadeService postFacadeService(UserProfileService userProfileService, PostService postService, ImageService imageService) {
    return new PostFacadeServiceImpl(userProfileService, postService, imageService);
  }

  @Bean
  public ImageFacadeService imageFacadeService(UserProfileService userProfileService, PostService postService, ImageService imageService) {
    return new ImageFacadeServiceImpl(userProfileService, postService, imageService);
  }

  @Bean
  public UserProfileFacadeService userProfileFacadeService(UserProfileService userProfileService, PostFacadeService postFacadeService) {
    return new UserProfileFacadeServiceImpl(userProfileService, postFacadeService);
  }

  @Bean
  public AuthTokenService authTokenService(RedisTemplate redisTemplate) {
    return new AuthTokenServiceImpl(accessTokenJwtSecret, accessTokenLifeTime, refreshTokenJwtSecret, refreshTokenLifeTime, redisTemplate);
  }

  @Bean
  public AuthFacadeService authFacadeService(UserProfileService userProfileService, AuthTokenService authTokenService, OtpService otpService, EmailService emailService) {
    return new AuthFacadeServiceImpl(userProfileService, authTokenService, accessTokenLifeTime, refreshTokenLifeTime, otpService, emailService);
  }

  @Bean
  public ReactionService reactionService(ReactionRepository reactionRepository) {
    return new ReactionServiceImpl(reactionRepository);
  }

  @Bean
  public ReactionFacadeService reactionFacadeService(ReactionService reactionService, PostService postService) {
    return new ReactionFacadeServiceImpl(reactionService, postService);
  }

  @Bean
  public CommentService commentService(CommentRepository commentRepository) {
    return new CommentServiceImpl(commentRepository);
  }

  @Bean
  public CommentFacadeService commentFacadeService(CommentService commentService, PostService postService) {
    return new CommentFacadeServiceImpl(commentService, postService);
  }
}
