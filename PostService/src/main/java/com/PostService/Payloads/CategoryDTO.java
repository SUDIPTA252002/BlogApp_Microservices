package com.PostService.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO 
{
    private Integer categoryId;

    private String categoryTitle;

    private String categoryDescription;

    private String slug;
    
}
