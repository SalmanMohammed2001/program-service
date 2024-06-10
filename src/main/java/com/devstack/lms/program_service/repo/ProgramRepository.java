package com.devstack.lms.program_service.repo;

import com.devstack.lms.program_service.entity.Program;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgramRepository extends MongoRepository<Program,String> {
}
