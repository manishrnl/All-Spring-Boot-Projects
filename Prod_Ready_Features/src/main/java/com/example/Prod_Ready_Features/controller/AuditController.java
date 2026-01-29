package com.example.Prod_Ready_Features.controller;

import com.example.Prod_Ready_Features.dto.PostRevisionDTO;
import com.example.Prod_Ready_Features.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;



    @GetMapping(path = "/posts/{postId}")
    public List<PostRevisionDTO> getPostRevisions(@PathVariable Long postId) {
        AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        List<Number> revisions = reader.getRevisions(PostEntity.class, postId);

        return revisions.stream().map(revNum -> {
            PostEntity entity = reader.find(PostEntity.class, postId, revNum);
            PostRevisionDTO dto = new PostRevisionDTO();
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setContent(entity.getDescription());
            dto.setRevisionNumber(revNum.intValue());
            return dto;
        }).collect(Collectors.toList());
    }


}
