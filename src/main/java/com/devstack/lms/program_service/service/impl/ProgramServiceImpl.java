package com.devstack.lms.program_service.service.impl;

import com.devstack.lms.program_service.dto.requestDto.RequestProgramDto;
import com.devstack.lms.program_service.entity.Program;
import com.devstack.lms.program_service.entity.Subject;
import com.devstack.lms.program_service.repo.ProgramRepository;
import com.devstack.lms.program_service.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {


    private final ProgramRepository programRepository;

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


     List<Long> ids= program.getSubjects().stream().map(Subject::getId).toList();
     



        programRepository.save(program);
    }
}
