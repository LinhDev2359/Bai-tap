package org.aibles.user_profile.filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class GenericSpecification<T> implements Specification<T> {

  private String key;
  private Object value;

  public GenericSpecification(String key, Object value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
    if (root.get(key).getJavaType() == String.class) {
      return builder.like(builder.lower(root.get(key)), "%" + value.toString().toLowerCase() + "%");
    } else {
      return builder.equal(root.get(key), value);
    }
  }
}
