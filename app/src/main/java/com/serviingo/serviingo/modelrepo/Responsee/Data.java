package com.serviingo.serviingo.modelrepo.Responsee;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("subsub_category")
	private List<SubsubCategoryItem> subsubCategory;

	@SerializedName("image_path")
	private String imagePath;

	public List<SubsubCategoryItem> getSubsubCategory(){
		return subsubCategory;
	}

	public String getImagePath(){
		return imagePath;
	}
}