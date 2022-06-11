package com.bei.forum.service;

import com.bei.forum.mapper.NewsMapper;
import com.bei.forum.mapper.PostsMapper;
import com.bei.forum.pojo.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsServiceImpl implements PostsService {

    PostsMapper postsMapper;
    NewsMapper newsMapper;

    @Autowired
    public void setPostsMapper(PostsMapper postsMapper) {
        this.postsMapper = postsMapper;
    }

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Override
    public Posts get(int id) {
        Posts post = postsMapper.get(id)[0];
        post.setLike(newsMapper.count(id, "like"));
        post.setCollection(newsMapper.count(id, "collect"));
        post.setComment(newsMapper.count(id, "comment"));
        return post;
    }

    @Override
    public Posts[] getAll() {
        return postsMapper.getAll();
    }

    @Override
    public Posts[] getByArea(String area) {
        return postsMapper.getByArea(area);
    }
}
