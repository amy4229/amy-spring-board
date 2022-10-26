package com.amy.springboard.repository;

import com.amy.springboard.domain.PostComment;
import com.amy.springboard.domain.QPostComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PostCommentRepository extends
        JpaRepository<PostComment, Long>,
        QuerydslPredicateExecutor<PostComment>,
        QuerydslBinderCustomizer<QPostComment> {

    @Override
    default void customize(QuerydslBindings bindings, QPostComment root){
        // 사용자가 정의한 리스트에 포함한 속성만 검색대상 (모든 속성값에 대한 검색 :false)
        bindings.excludeUnlistedProperties(true);
        //TODO id, 닉네임
        bindings.including(root.content, root.createdAt, root.createdBy);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }
}
