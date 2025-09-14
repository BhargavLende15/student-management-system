package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.application.mapper.TeacherMapper;
import com.rcoem.sms.domain.entities.Teacher;
import com.rcoem.sms.domain.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherServiceImpl implements TeacherService {
    
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<TeacherDetails> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(teacher -> teacherMapper.toDto(teacher))
                .toList();
    }

    @Override
    public TeacherDetails createTeacher(TeacherDetails teacherDetails) {
        String teacherId = "TEACHER" + UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        teacherDetails.setTeacherId(teacherId);
        teacherDetails.setCreatedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        teacherDetails.setIsActive(true);
        
        Teacher insertedRecord = teacherRepository.save(teacherMapper.toEntity(teacherDetails));
        return teacherMapper.toDto(insertedRecord);
    }

    @Override
    public TeacherDetails getTeacherById(String teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        return teacher.isPresent() ? teacherMapper.toDto(teacher.get()) : null;
    }

    @Override
    public TeacherDetails updateTeacherById(TeacherDetails teacherDetails) {
        Optional<Teacher> existingTeacher = teacherRepository.findById(teacherDetails.getTeacherId());
        if (existingTeacher.isPresent()) {
            Teacher updatedTeacher = teacherRepository.save(teacherMapper.toEntity(teacherDetails));
            return teacherMapper.toDto(updatedTeacher);
        }
        return null;
    }

    @Override
    public void deleteTeacherById(String teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
