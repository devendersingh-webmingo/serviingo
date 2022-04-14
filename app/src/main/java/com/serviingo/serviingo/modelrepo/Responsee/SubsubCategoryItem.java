package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.SerializedName;

public class SubsubCategoryItem{

	@SerializedName("short_description")
	private String shortDescription;

	@SerializedName("meta_title")
	private String metaTitle;

	@SerializedName("icon")
	private String icon;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("background_image")
	private String backgroundImage;

	@SerializedName("meta_description")
	private String metaDescription;

	@SerializedName("category_id")
	private int categoryId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("sub_category_id")
	private int subCategoryId;

	@SerializedName("meta_keyword")
	private String metaKeyword;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("state_id")
	private int stateId;

	@SerializedName("slug")
	private String slug;

	@SerializedName("city_id")
	private int cityId;

	@SerializedName("status")
	private int status;

	public String getShortDescription(){
		return shortDescription;
	}

	public String getMetaTitle(){
		return metaTitle;
	}

	public String getIcon(){
		return icon;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public String getBackgroundImage(){
		return backgroundImage;
	}

	public String getMetaDescription(){
		return metaDescription;
	}

	public int getCategoryId(){
		return categoryId;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public int getSubCategoryId(){
		return subCategoryId;
	}

	public String getMetaKeyword(){
		return metaKeyword;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public int getStateId(){
		return stateId;
	}

	public String getSlug(){
		return slug;
	}

	public int getCityId(){
		return cityId;
	}

	public int getStatus(){
		return status;
	}
}