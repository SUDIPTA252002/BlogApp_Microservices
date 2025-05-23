package com.CategoryService.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Category")
public class Category 
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer categoryId;

    @Column(name="Category Title",nullable=false,length=100)
    private String categoryTitle;
    
    @Column(name="Category Description",nullable=false,length=500)
    private String categoryDescription;
    
    @Column(name = "slug", nullable = false, unique = true)
    private String slug; 

    // @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    // private List<Post> Posts=new ArrayList<>();
}
