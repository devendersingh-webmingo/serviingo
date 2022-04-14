package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AboutRepo {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {

        @SerializedName("image_path")
        @Expose
        private String imagePath;
        @SerializedName("about_content")
        @Expose
        private AboutContent aboutContent;


        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public AboutContent getAboutContent() {
            return aboutContent;
        }

        public void setAboutContent(AboutContent aboutContent) {
            this.aboutContent = aboutContent;
        }


        public class AboutContent {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("image")
            @Expose
            private String image;
            @SerializedName("heading")
            @Expose
            private String heading;
            @SerializedName("short_description")
            @Expose
            private String shortDescription;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("section1_heading")
            @Expose
            private String section1Heading;
            @SerializedName("section1_description")
            @Expose
            private String section1Description;
            @SerializedName("section2_heading")
            @Expose
            private String section2Heading;
            @SerializedName("section2_description")
            @Expose
            private String section2Description;
            @SerializedName("section3_image")
            @Expose
            private String section3Image;
            @SerializedName("section3_heading")
            @Expose
            private String section3Heading;
            @SerializedName("section3_description")
            @Expose
            private String section3Description;
            @SerializedName("service_provide")
            @Expose
            private String serviceProvide;
            @SerializedName("section_four_heading")
            @Expose
            private String sectionFourHeading;
            @SerializedName("section_four_title")
            @Expose
            private String sectionFourTitle;
            @SerializedName("tab_one_title")
            @Expose
            private String tabOneTitle;
            @SerializedName("tab_one_count")
            @Expose
            private String tabOneCount;
            @SerializedName("tab_two_title")
            @Expose
            private String tabTwoTitle;
            @SerializedName("tab_two_count")
            @Expose
            private String tabTwoCount;
            @SerializedName("tab_three_title")
            @Expose
            private String tabThreeTitle;
            @SerializedName("tab_three_count")
            @Expose
            private String tabThreeCount;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getHeading() {
                return heading;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public String getShortDescription() {
                return shortDescription;
            }

            public void setShortDescription(String shortDescription) {
                this.shortDescription = shortDescription;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getSection1Heading() {
                return section1Heading;
            }

            public void setSection1Heading(String section1Heading) {
                this.section1Heading = section1Heading;
            }

            public String getSection1Description() {
                return section1Description;
            }

            public void setSection1Description(String section1Description) {
                this.section1Description = section1Description;
            }

            public String getSection2Heading() {
                return section2Heading;
            }

            public void setSection2Heading(String section2Heading) {
                this.section2Heading = section2Heading;
            }

            public String getSection2Description() {
                return section2Description;
            }

            public void setSection2Description(String section2Description) {
                this.section2Description = section2Description;
            }

            public String getSection3Image() {
                return section3Image;
            }

            public void setSection3Image(String section3Image) {
                this.section3Image = section3Image;
            }

            public String getSection3Heading() {
                return section3Heading;
            }

            public void setSection3Heading(String section3Heading) {
                this.section3Heading = section3Heading;
            }

            public String getSection3Description() {
                return section3Description;
            }

            public void setSection3Description(String section3Description) {
                this.section3Description = section3Description;
            }

            public String getServiceProvide() {
                return serviceProvide;
            }

            public void setServiceProvide(String serviceProvide) {
                this.serviceProvide = serviceProvide;
            }

            public String getSectionFourHeading() {
                return sectionFourHeading;
            }

            public void setSectionFourHeading(String sectionFourHeading) {
                this.sectionFourHeading = sectionFourHeading;
            }

            public String getSectionFourTitle() {
                return sectionFourTitle;
            }

            public void setSectionFourTitle(String sectionFourTitle) {
                this.sectionFourTitle = sectionFourTitle;
            }

            public String getTabOneTitle() {
                return tabOneTitle;
            }

            public void setTabOneTitle(String tabOneTitle) {
                this.tabOneTitle = tabOneTitle;
            }

            public String getTabOneCount() {
                return tabOneCount;
            }

            public void setTabOneCount(String tabOneCount) {
                this.tabOneCount = tabOneCount;
            }

            public String getTabTwoTitle() {
                return tabTwoTitle;
            }

            public void setTabTwoTitle(String tabTwoTitle) {
                this.tabTwoTitle = tabTwoTitle;
            }

            public String getTabTwoCount() {
                return tabTwoCount;
            }

            public void setTabTwoCount(String tabTwoCount) {
                this.tabTwoCount = tabTwoCount;
            }

            public String getTabThreeTitle() {
                return tabThreeTitle;
            }

            public void setTabThreeTitle(String tabThreeTitle) {
                this.tabThreeTitle = tabThreeTitle;
            }

            public String getTabThreeCount() {
                return tabThreeCount;
            }

            public void setTabThreeCount(String tabThreeCount) {
                this.tabThreeCount = tabThreeCount;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

        }
    }
}