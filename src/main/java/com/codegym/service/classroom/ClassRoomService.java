package com.codegym.service.classroom;

import com.codegym.model.ClassRoom;
import com.codegym.repository.IClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomService implements IClassRoomService{
    @Autowired
    IClassRoomRepository classRoomRepository;
    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public Optional<ClassRoom> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
