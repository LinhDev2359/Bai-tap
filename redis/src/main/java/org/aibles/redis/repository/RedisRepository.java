package org.aibles.redis.repository;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.aibles.redis.entity.Student;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository  {

  private final RedisTemplate redisTemplate;

  private final String REDIS_KEY = "STUDENT";
  private final long TIME_TO_LIVE = 3600;

  public RedisRepository(RedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @EventListener
  public void onApplicationEvent(ApplicationReadyEvent event) {
    List<Student> students = redisTemplate.opsForHash().values(REDIS_KEY);
    System.out.println(students);
    for (Student student : students) delete(student.getId());
  }

  public void save(Student student){
    redisTemplate.opsForHash().put(REDIS_KEY, student.getId(), student);
    redisTemplate.expire(REDIS_KEY, TIME_TO_LIVE, TimeUnit.MILLISECONDS);
  }

  public Student findById(long id){
    Student student = (Student) redisTemplate.opsForHash().get(REDIS_KEY, id);
    if (Objects.nonNull(student)){
      this.save(student);
    }
    return student;
  }

  public void delete(long userId){
    redisTemplate.opsForHash().delete(REDIS_KEY, userId);
    System.out.println("delete");
  }

  public List findAll(){
    return redisTemplate.opsForHash().values(REDIS_KEY);
  }
}
