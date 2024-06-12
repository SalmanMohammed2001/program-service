package com.devstack.lms.program_service.service.impl;

import com.devstack.lms.program_service.dto.ResponseProgramDto;
import com.devstack.lms.program_service.dto.requestDto.RequestProgramDto;
import com.devstack.lms.program_service.entity.Program;
import com.devstack.lms.program_service.entity.Subject;
import com.devstack.lms.program_service.repo.ProgramRepository;
import com.devstack.lms.program_service.service.ProgramService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {


    private final ProgramRepository programRepository;
    private final ProgramAspectServiceImpl programAspectService;


    @Override
    public void createProgram(RequestProgramDto programDto) {
        Program program = Program.builder().
                name(programDto.getName())
                .price(programDto.getPrice())
                .startData(programDto
                        .getStartData())
                .subjects(programDto
                        .getSubjects()).build();

        //get All subject and need check if there are available or not


      //  List<Long> ids = program.getSubjects().stream().map(Subject::getId).toList();
        List<Long> list=new ArrayList<>();
        for (Subject sub:
             program.getSubjects()) {
            list.add(sub.getId());
        }

        String ids= list.stream().map(Object::toString).collect(Collectors.joining(", "));
       Boolean isOk=  programAspectService.checkSubject(ids);

       if (Boolean.TRUE.equals(isOk)){
           programRepository.save(program);
       }else {
           throw new IllegalArgumentException("Try Again with Valid subject");
       }


    }



    @Override
    public List<ResponseProgramDto> findAllProgram() {
        List<Program> all = programRepository.findAll();

    List<ResponseProgramDto>  responseProgramDtoList=   new ArrayList<>();
        for (Program p:all) {
            responseProgramDtoList.add(new ResponseProgramDto(
                    p.getId(),p.getName(),p.getPrice(),p.getStartData(),p.getSubjects()));
        }
        return responseProgramDtoList;
    }
}
