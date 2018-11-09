package com.example.indus.businesscard.database;

import com.example.indus.businesscard.modeldto.MultimediaItem;
import com.example.indus.businesscard.modeldto.NewsEntity;
import com.example.indus.businesscard.modeldto.NewsItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

public class NewsTypeConverter {

    @TypeConverter
    public static List <MultimediaItem> stringToMultimedia(String json){
        Gson gson = new Gson();
        Type type = new TypeToken<List<MultimediaItem>>() {}.getType();
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String multimediaToString(List<MultimediaItem> multimediaItems){
        Gson gson = new Gson();
        Type type = new TypeToken<List<MultimediaItem>>(){}.getType();
        return gson.toJson(multimediaItems, type);
    }

    public static NewsEntity newsToDatabase(NewsItem newsItem) {
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setSubsection(newsItem.getSubsection());
        newsEntity.setPreviewText(newsItem.getPreviewText());
        newsEntity.setTitle(newsItem.getTitle());
        newsEntity.setUrl(newsItem.getUrl());
        newsEntity.setMultimedia(newsItem.getMultimedia());
        newsEntity.setPublishedDate(newsItem.getPublishedDate());
        return newsEntity;
    }

    public static NewsItem newsFromDatabase(NewsEntity newsEntity) {
        NewsItem newsItem = new NewsItem();
        newsItem.setSubsection(newsEntity.getSubsection());
        newsItem.setPreviewText(newsEntity.getPreviewText());
        newsItem.setTitle(newsEntity.getTitle());
        newsItem.setUrl(newsEntity.getUrl());
        newsItem.setMultimedia(newsEntity.getMultimedia());
        newsItem.setPublishedDate(newsEntity.getPublishedDate());
        return newsItem;
    }
}
