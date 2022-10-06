package org.aibles.worker2.mapper;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import liquibase.repackaged.org.apache.commons.collections4.CollectionUtils;
import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.utility.dispatcher.JavaDispatcher.Instance;

public class WorkerMapper {


  private static WorkerMapper instance;

  private static ModelMapper modelMapper;
  public WorkerMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;

  }

//  public static  WorkerMapper getInstance(){
////    if(instance == null){
////      instance = new WorkerMapper();
////    }
////    return instance;
//      if (instance == null) {
//        sync (WorkerMapper.class); {
//          if (instance == null) {
//            instance = new WorkerMapper (modelMapper, instance);
//          }
//        }
//      }
//      return instance;
//  }

//  private static void sync(Class<WorkerMapper> workerMapperClass) {
//  }

  public WorkerDto mapToDto(Worker worker) {
    return modelMapper.map(worker, WorkerDto.class);
  }

  public Worker mapToEntity(WorkerDto workerDto) {

    return  modelMapper.map(workerDto, Worker.class);
  }
  public <T, H> List<T> mapList(List<H> inputData, Class<T> clazz) {
    return CollectionUtils.isEmpty(inputData) ?
        Collections.emptyList() :
        inputData.stream()
            .map(i -> modelMapper.map(i, clazz))
            .collect(Collectors.toList());
  }

}
