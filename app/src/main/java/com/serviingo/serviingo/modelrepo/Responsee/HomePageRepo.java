package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomePageRepo {


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





        @SerializedName("logo")
        @Expose
        private Logo logo;
        @SerializedName("city")
        @Expose
        private City city;
        @SerializedName("category_image_path")
        @Expose
        private String categoryImagePath;
        @SerializedName("sub_category_image_path")
        @Expose
        private String subCategoryImagePath;
        @SerializedName("subsub_category_image_path")
        @Expose
        private String subsubCategoryImagePath;
        @SerializedName("about_image_path")
        @Expose
        private String aboutImagePath;
        @SerializedName("finance")
        @Expose
        private Finance finance;
        @SerializedName("all_categories")
        @Expose
        private List<AllCategory> allCategories = null;
        @SerializedName("recent_categories")
        @Expose
        private List<RecentCategory> recentCategories = null;
        @SerializedName("main_section")
        @Expose
        private MainSection mainSection;
        @SerializedName("about_content")
        @Expose
        private AboutContent aboutContent;
        @SerializedName("sliders")
        @Expose
        private List<Slider> sliders = null;
        @SerializedName("middle_sliders")
        @Expose
        private List<MiddleSlider> middleSliders = null;
        @SerializedName("one_section")
        @Expose
        private OneSection oneSection;
        @SerializedName("two_section")
        @Expose
        private TwoSection twoSection;
        @SerializedName("three_section")
        @Expose
        private ThreeSection threeSection;
        @SerializedName("four_section")
        @Expose
        private FourSection fourSection;



        @SerializedName("home_subsub_categories")
        @Expose
        private List<HomeSubsubCategory> homeSubsubCategories = null;


        @SerializedName("gallery_images")
        @Expose
        private List<GalleryImage> galleryImages = null;
        @SerializedName("reviews")
        @Expose
        private List<Review> reviews = null;
        @SerializedName("refer_and_earn")
        @Expose
        private ReferAndEarn referAndEarn;
        @SerializedName("serve_cities")
        @Expose
        private List<ServeCity> serveCities = null;
        @SerializedName("soon_cities")
        @Expose
        private List<Object> soonCities = null;
        @SerializedName("latest_services")
        @Expose
        private List<LatestService> latestServices = null;
        @SerializedName("facebook_link")
        @Expose
        private FacebookLink facebookLink;
        @SerializedName("twitter_link")
        @Expose
        private TwitterLink twitterLink;
        @SerializedName("insta_link")
        @Expose
        private InstaLink instaLink;
        @SerializedName("youtube_link")
        @Expose
        private YoutubeLink youtubeLink;
        @SerializedName("linkedin_link")
        @Expose
        private LinkedinLink linkedinLink;
        @SerializedName("pinterest_link")
        @Expose
        private PinterestLink pinterestLink;


        @SerializedName("sub_categories")
        @Expose
        private List<SubCategory> subCategories = null;

        public Logo getLogo() {
            return logo;
        }

        public void setLogo(Logo logo) {
            this.logo = logo;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }

        public String getCategoryImagePath() {
            return categoryImagePath;
        }

        public void setCategoryImagePath(String categoryImagePath) {
            this.categoryImagePath = categoryImagePath;
        }

        public String getSubCategoryImagePath() {
            return subCategoryImagePath;
        }

        public void setSubCategoryImagePath(String subCategoryImagePath) {
            this.subCategoryImagePath = subCategoryImagePath;
        }

        public String getSubsubCategoryImagePath() {
            return subsubCategoryImagePath;
        }

        public void setSubsubCategoryImagePath(String subsubCategoryImagePath) {
            this.subsubCategoryImagePath = subsubCategoryImagePath;
        }

        public String getAboutImagePath() {
            return aboutImagePath;
        }

        public void setAboutImagePath(String aboutImagePath) {
            this.aboutImagePath = aboutImagePath;
        }

        public Finance getFinance() {
            return finance;
        }

        public void setFinance(Finance finance) {
            this.finance = finance;
        }

        public List<AllCategory> getAllCategories() {
            return allCategories;
        }

        public void setAllCategories(List<AllCategory> allCategories) {
            this.allCategories = allCategories;
        }

        public List<RecentCategory> getRecentCategories() {
            return recentCategories;
        }

        public void setRecentCategories(List<RecentCategory> recentCategories) {
            this.recentCategories = recentCategories;
        }

        public MainSection getMainSection() {
            return mainSection;
        }

        public void setMainSection(MainSection mainSection) {
            this.mainSection = mainSection;
        }

        public AboutContent getAboutContent() {
            return aboutContent;
        }

        public void setAboutContent(AboutContent aboutContent) {
            this.aboutContent = aboutContent;
        }

        public List<Slider> getSliders() {
            return sliders;
        }

        public void setSliders(List<Slider> sliders) {
            this.sliders = sliders;
        }

        public List<MiddleSlider> getMiddleSliders() {
            return middleSliders;
        }

        public void setMiddleSliders(List<MiddleSlider> middleSliders) {
            this.middleSliders = middleSliders;
        }

        public OneSection getOneSection() {
            return oneSection;
        }

        public void setOneSection(OneSection oneSection) {
            this.oneSection = oneSection;
        }

        public TwoSection getTwoSection() {
            return twoSection;
        }

        public void setTwoSection(TwoSection twoSection) {
            this.twoSection = twoSection;
        }

        public ThreeSection getThreeSection() {
            return threeSection;
        }

        public void setThreeSection(ThreeSection threeSection) {
            this.threeSection = threeSection;
        }

        public FourSection getFourSection() {
            return fourSection;
        }

        public void setFourSection(FourSection fourSection) {
            this.fourSection = fourSection;
        }


        public List<HomeSubsubCategory> getHomeSubsubCategories() {
            return homeSubsubCategories;
        }

        public void setHomeSubsubCategories(List<HomeSubsubCategory> homeSubsubCategories) {
            this.homeSubsubCategories = homeSubsubCategories;
        }
        public List<GalleryImage> getGalleryImages() {
            return galleryImages;
        }

        public void setGalleryImages(List<GalleryImage> galleryImages) {
            this.galleryImages = galleryImages;
        }

        public List<Review> getReviews() {
            return reviews;
        }

        public void setReviews(List<Review> reviews) {
            this.reviews = reviews;
        }

        public ReferAndEarn getReferAndEarn() {
            return referAndEarn;
        }

        public void setReferAndEarn(ReferAndEarn referAndEarn) {
            this.referAndEarn = referAndEarn;
        }

        public List<ServeCity> getServeCities() {
            return serveCities;
        }

        public void setServeCities(List<ServeCity> serveCities) {
            this.serveCities = serveCities;
        }

        public List<Object> getSoonCities() {
            return soonCities;
        }

        public void setSoonCities(List<Object> soonCities) {
            this.soonCities = soonCities;
        }

        public List<LatestService> getLatestServices() {
            return latestServices;
        }

        public void setLatestServices(List<LatestService> latestServices) {
            this.latestServices = latestServices;
        }

        public FacebookLink getFacebookLink() {
            return facebookLink;
        }

        public void setFacebookLink(FacebookLink facebookLink) {
            this.facebookLink = facebookLink;
        }

        public TwitterLink getTwitterLink() {
            return twitterLink;
        }

        public void setTwitterLink(TwitterLink twitterLink) {
            this.twitterLink = twitterLink;
        }

        public InstaLink getInstaLink() {
            return instaLink;
        }

        public void setInstaLink(InstaLink instaLink) {
            this.instaLink = instaLink;
        }

        public YoutubeLink getYoutubeLink() {
            return youtubeLink;
        }

        public void setYoutubeLink(YoutubeLink youtubeLink) {
            this.youtubeLink = youtubeLink;
        }

        public LinkedinLink getLinkedinLink() {
            return linkedinLink;
        }

        public void setLinkedinLink(LinkedinLink linkedinLink) {
            this.linkedinLink = linkedinLink;
        }

        public PinterestLink getPinterestLink() {
            return pinterestLink;
        }

        public void setPinterestLink(PinterestLink pinterestLink) {
            this.pinterestLink = pinterestLink;
        }

        public List<SubCategory> getSubCategories() {
            return subCategories;
        }

        public void setSubCategories(List<SubCategory> subCategories) {
            this.subCategories = subCategories;
        }


        public class Logo {

            @SerializedName("logo")
            @Expose
            private String logo;

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

        }

        public class City {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("created_at")
            @Expose
            private Object createdAt;
            @SerializedName("updated_at")
            @Expose
            private Object updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(Object createdAt) {
                this.createdAt = createdAt;
            }

            public Object getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(Object updatedAt) {
                this.updatedAt = updatedAt;
            }

        }

        public class Finance {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("heading")
            @Expose
            private String heading;
            @SerializedName("title")
            @Expose
            private Object title;
            @SerializedName("description")
            @Expose
            private Object description;
            @SerializedName("images")
            @Expose
            private String images;
            @SerializedName("categories_ids")
            @Expose
            private Object categoriesIds;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getHeading() {
                return heading;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public Object getCategoriesIds() {
                return categoriesIds;
            }

            public void setCategoriesIds(Object categoriesIds) {
                this.categoriesIds = categoriesIds;
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

        public class AllCategory {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("icon")
            @Expose
            private String icon;
            @SerializedName("background_image")
            @Expose
            private String backgroundImage;




            @SerializedName("detail_image")
            @Expose
            private String detail_image ;

            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("reviews_heading")
            @Expose
            private String reviewsHeading;
            @SerializedName("reviews_title")
            @Expose
            private String reviewsTitle;
            @SerializedName("faq_title")
            @Expose
            private String faqTitle;
            @SerializedName("short_description")
            @Expose
            private String shortDescription;
            @SerializedName("about_category")
            @Expose
            private String aboutCategory;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("meta_title")
            @Expose
            private String metaTitle;
            @SerializedName("meta_keywords")
            @Expose
            private String metaKeywords;
            @SerializedName("meta_description")
            @Expose
            private String metaDescription;
            @SerializedName("avg_rating")
            @Expose
            private String avgRating;
            @SerializedName("banner_title")
            @Expose
            private String bannerTitle;
            @SerializedName("banner_description")
            @Expose
            private String bannerDescription;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private Object deletedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getBackgroundImage() {
                return backgroundImage;
            }

            public void setBackgroundImage(String backgroundImage) {
                this.backgroundImage = backgroundImage;
            }

            public String getDetail_image() {
                return detail_image;
            }

            public void setDetail_image(String detail_image) {
                this.detail_image = detail_image;
            }
            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getReviewsHeading() {
                return reviewsHeading;
            }

            public void setReviewsHeading(String reviewsHeading) {
                this.reviewsHeading = reviewsHeading;
            }

            public String getReviewsTitle() {
                return reviewsTitle;
            }

            public void setReviewsTitle(String reviewsTitle) {
                this.reviewsTitle = reviewsTitle;
            }

            public String getFaqTitle() {
                return faqTitle;
            }

            public void setFaqTitle(String faqTitle) {
                this.faqTitle = faqTitle;
            }

            public String getShortDescription() {
                return shortDescription;
            }

            public void setShortDescription(String shortDescription) {
                this.shortDescription = shortDescription;
            }

            public String getAboutCategory() {
                return aboutCategory;
            }

            public void setAboutCategory(String aboutCategory) {
                this.aboutCategory = aboutCategory;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getMetaTitle() {
                return metaTitle;
            }

            public void setMetaTitle(String metaTitle) {
                this.metaTitle = metaTitle;
            }

            public String getMetaKeywords() {
                return metaKeywords;
            }

            public void setMetaKeywords(String metaKeywords) {
                this.metaKeywords = metaKeywords;
            }

            public String getMetaDescription() {
                return metaDescription;
            }

            public void setMetaDescription(String metaDescription) {
                this.metaDescription = metaDescription;
            }

            public String getAvgRating() {
                return avgRating;
            }

            public void setAvgRating(String avgRating) {
                this.avgRating = avgRating;
            }

            public String getBannerTitle() {
                return bannerTitle;
            }

            public void setBannerTitle(String bannerTitle) {
                this.bannerTitle = bannerTitle;
            }

            public String getBannerDescription() {
                return bannerDescription;
            }

            public void setBannerDescription(String bannerDescription) {
                this.bannerDescription = bannerDescription;
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

            public Object getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(Object deletedAt) {
                this.deletedAt = deletedAt;
            }

        }

        public class RecentCategory {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("icon")
            @Expose
            private String icon;
            @SerializedName("background_image")
            @Expose
            private String backgroundImage;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("reviews_heading")
            @Expose
            private String reviewsHeading;
            @SerializedName("reviews_title")
            @Expose
            private String reviewsTitle;
            @SerializedName("faq_title")
            @Expose
            private String faqTitle;
            @SerializedName("short_description")
            @Expose
            private String shortDescription;
            @SerializedName("about_category")
            @Expose
            private String aboutCategory;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("meta_title")
            @Expose
            private String metaTitle;
            @SerializedName("meta_keywords")
            @Expose
            private String metaKeywords;
            @SerializedName("meta_description")
            @Expose
            private String metaDescription;
            @SerializedName("avg_rating")
            @Expose
            private String avgRating;
            @SerializedName("banner_title")
            @Expose
            private String bannerTitle;
            @SerializedName("banner_description")
            @Expose
            private String bannerDescription;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private Object deletedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getBackgroundImage() {
                return backgroundImage;
            }

            public void setBackgroundImage(String backgroundImage) {
                this.backgroundImage = backgroundImage;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getReviewsHeading() {
                return reviewsHeading;
            }

            public void setReviewsHeading(String reviewsHeading) {
                this.reviewsHeading = reviewsHeading;
            }

            public String getReviewsTitle() {
                return reviewsTitle;
            }

            public void setReviewsTitle(String reviewsTitle) {
                this.reviewsTitle = reviewsTitle;
            }

            public String getFaqTitle() {
                return faqTitle;
            }

            public void setFaqTitle(String faqTitle) {
                this.faqTitle = faqTitle;
            }

            public String getShortDescription() {
                return shortDescription;
            }

            public void setShortDescription(String shortDescription) {
                this.shortDescription = shortDescription;
            }

            public String getAboutCategory() {
                return aboutCategory;
            }

            public void setAboutCategory(String aboutCategory) {
                this.aboutCategory = aboutCategory;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getMetaTitle() {
                return metaTitle;
            }

            public void setMetaTitle(String metaTitle) {
                this.metaTitle = metaTitle;
            }

            public String getMetaKeywords() {
                return metaKeywords;
            }

            public void setMetaKeywords(String metaKeywords) {
                this.metaKeywords = metaKeywords;
            }

            public String getMetaDescription() {
                return metaDescription;
            }

            public void setMetaDescription(String metaDescription) {
                this.metaDescription = metaDescription;
            }

            public String getAvgRating() {
                return avgRating;
            }

            public void setAvgRating(String avgRating) {
                this.avgRating = avgRating;
            }

            public String getBannerTitle() {
                return bannerTitle;
            }

            public void setBannerTitle(String bannerTitle) {
                this.bannerTitle = bannerTitle;
            }

            public String getBannerDescription() {
                return bannerDescription;
            }

            public void setBannerDescription(String bannerDescription) {
                this.bannerDescription = bannerDescription;
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

            public Object getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(Object deletedAt) {
                this.deletedAt = deletedAt;
            }

        }

        public class MainSection {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("heading")
            @Expose
            private String heading;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private Object description;
            @SerializedName("images")
            @Expose
            private Object images;
            @SerializedName("categories_ids")
            @Expose
            private String categoriesIds;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getHeading() {
                return heading;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public Object getImages() {
                return images;
            }

            public void setImages(Object images) {
                this.images = images;
            }

            public String getCategoriesIds() {
                return categoriesIds;
            }

            public void setCategoriesIds(String categoriesIds) {
                this.categoriesIds = categoriesIds;
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

        public class AboutContent {

            @SerializedName("id")
            @Expose
            private String id;
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

            public String getId() {
                return id;
            }

            public void setId(String id) {
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

        public class Slider {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
            @SerializedName("url")
            @Expose
            private String url;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;



            @SerializedName("redirection_type")
            @Expose
            private RedirectionType redirectionType;

            @SerializedName("page_type")
            @Expose
            private String pageType;

            public String getPageType() {
                return pageType;
            }

            public void setPageType(String pageType) {
                this.pageType = pageType;
            }


            public RedirectionType getRedirectionType() {
                return redirectionType;
            }

            public void setRedirectionType(RedirectionType redirectionType) {
                this.redirectionType = redirectionType;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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

            public class RedirectionType {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("redirect")
                @Expose
                private String redirect;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getRedirect() {
                    return redirect;
                }

                public void setRedirect(String redirect) {
                    this.redirect = redirect;
                }

            }



        }

        public class MiddleSlider {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
            @SerializedName("url")
            @Expose
            private String url;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;



            @SerializedName("redirection_type")
            @Expose
            private RedirectionType redirectionType;

            @SerializedName("page_type")
            @Expose
            private String pageType;

            public RedirectionType getRedirectionType() {
                return redirectionType;
            }

            public void setRedirectionType(RedirectionType redirectionType) {
                this.redirectionType = redirectionType;
            }

            public String getPageType() {
                return pageType;
            }

            public void setPageType(String pageType) {
                this.pageType = pageType;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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


            public class RedirectionType {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("redirect")
                @Expose
                private String redirect;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getRedirect() {
                    return redirect;
                }

                public void setRedirect(String redirect) {
                    this.redirect = redirect;
                }

            }

        }

        public class OneSection {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("heading")
            @Expose
            private Object heading;
            @SerializedName("title")
            @Expose
            private Object title;
            @SerializedName("description")
            @Expose
            private Object description;
            @SerializedName("images")
            @Expose
            private String images;
            @SerializedName("categories_ids")
            @Expose
            private Object categoriesIds;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public Object getHeading() {
                return heading;
            }

            public void setHeading(Object heading) {
                this.heading = heading;
            }

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public Object getCategoriesIds() {
                return categoriesIds;
            }

            public void setCategoriesIds(Object categoriesIds) {
                this.categoriesIds = categoriesIds;
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

        public class TwoSection {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("heading")
            @Expose
            private String heading;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private Object description;
            @SerializedName("images")
            @Expose
            private Object images;
            @SerializedName("categories_ids")
            @Expose
            private String categoriesIds;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getHeading() {
                return heading;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public Object getImages() {
                return images;
            }

            public void setImages(Object images) {
                this.images = images;
            }

            public String getCategoriesIds() {
                return categoriesIds;
            }

            public void setCategoriesIds(String categoriesIds) {
                this.categoriesIds = categoriesIds;
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

        public class ThreeSection {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("heading")
            @Expose
            private String heading;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private Object description;
            @SerializedName("images")
            @Expose
            private Object images;
            @SerializedName("categories_ids")
            @Expose
            private String categoriesIds;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getHeading() {
                return heading;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public Object getImages() {
                return images;
            }

            public void setImages(Object images) {
                this.images = images;
            }

            public String getCategoriesIds() {
                return categoriesIds;
            }

            public void setCategoriesIds(String categoriesIds) {
                this.categoriesIds = categoriesIds;
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

        public class FourSection {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("heading")
            @Expose
            private String heading;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private Object description;
            @SerializedName("images")
            @Expose
            private Object images;
            @SerializedName("categories_ids")
            @Expose
            private String categoriesIds;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getHeading() {
                return heading;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public Object getImages() {
                return images;
            }

            public void setImages(Object images) {
                this.images = images;
            }

            public String getCategoriesIds() {
                return categoriesIds;
            }

            public void setCategoriesIds(String categoriesIds) {
                this.categoriesIds = categoriesIds;
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


        public class HomeSubsubCategory {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("detail_image")
            @Expose
            private String detailImage;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDetailImage() {
                return detailImage;
            }

            public void setDetailImage(String detailImage) {
                this.detailImage = detailImage;
            }

        }



   /*     public class GalleryImage {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("link")
            @Expose
            private String link;
            @SerializedName("images")
            @Expose
            private String images;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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

        }*/

        public class GalleryImage {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("link")
            @Expose
            private String link;
            @SerializedName("images")
            @Expose
            private String images;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("page_type")
            @Expose
            private String pageType;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("redirection_type")
            @Expose
            private RedirectionType redirectionType;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPageType() {
                return pageType;
            }

            public void setPageType(String pageType) {
                this.pageType = pageType;
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

            public RedirectionType getRedirectionType() {
                return redirectionType;
            }

            public void setRedirectionType(RedirectionType redirectionType) {
                this.redirectionType = redirectionType;
            }



            public class RedirectionType {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("redirect")
                @Expose
                private String redirect;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getRedirect() {
                    return redirect;
                }

                public void setRedirect(String redirect) {
                    this.redirect = redirect;
                }

            }

        }

        public class ServeCity {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("created_at")
            @Expose
            private Object createdAt;
            @SerializedName("updated_at")
            @Expose
            private Object updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(Object createdAt) {
                this.createdAt = createdAt;
            }

            public Object getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(Object updatedAt) {
                this.updatedAt = updatedAt;
            }

        }

        public class Review {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("order_id")
            @Expose
            private String orderId;
            @SerializedName("user_id")
            @Expose
            private String userId;
            @SerializedName("package_id")
            @Expose
            private String packageId;
            @SerializedName("category_id")
            @Expose
            private String categoryId;
            @SerializedName("rating")
            @Expose
            private String rating;
            @SerializedName("review")
            @Expose
            private String review;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("created_at")
            @Expose
            private String createdAt;


            @SerializedName("review_city_id")
            @Expose
            private String review_city_id;

            public String getReview_city_id() {
                return review_city_id;
            }

            public void setReview_city_id(String review_city_id) {
                this.review_city_id = review_city_id;
            }

            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("get_user_info")
            @Expose
            private GetUserInfo getUserInfo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getPackageId() {
                return packageId;
            }

            public void setPackageId(String packageId) {
                this.packageId = packageId;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }

            public String getReview() {
                return review;
            }

            public void setReview(String review) {
                this.review = review;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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

            public GetUserInfo getGetUserInfo() {
                return getUserInfo;
            }

            public void setGetUserInfo(GetUserInfo getUserInfo) {
                this.getUserInfo = getUserInfo;
            }

            public class GetUserInfo {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("profile_photo_path")
                @Expose
                private String profilePhotoPath;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getProfilePhotoPath() {
                    return profilePhotoPath;
                }

                public void setProfilePhotoPath(String profilePhotoPath) {
                    this.profilePhotoPath = profilePhotoPath;
                }

            }
        }
        public class LatestService {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("category_id")
            @Expose
            private String categoryId;
            @SerializedName("sub_category_id")
            @Expose
            private String subCategoryId;
            @SerializedName("sub_sub_category_id")
            @Expose
            private String subSubCategoryId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("amount")
            @Expose
            private String amount;
            @SerializedName("discount")
            @Expose
            private String discount;
            @SerializedName("after_discount")
            @Expose
            private String afterDiscount;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("icon")
            @Expose
            private String icon;
            @SerializedName("detail_image")
            @Expose
            private String detailImage;
            @SerializedName("description")
            @Expose
            private Object description;
            @SerializedName("detail_video")
            @Expose
            private Object detailVideo;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private Object deletedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public String getSubCategoryId() {
                return subCategoryId;
            }

            public void setSubCategoryId(String subCategoryId) {
                this.subCategoryId = subCategoryId;
            }

            public String getSubSubCategoryId() {
                return subSubCategoryId;
            }

            public void setSubSubCategoryId(String subSubCategoryId) {
                this.subSubCategoryId = subSubCategoryId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
            }

            public String getAfterDiscount() {
                return afterDiscount;
            }

            public void setAfterDiscount(String afterDiscount) {
                this.afterDiscount = afterDiscount;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getDetailImage() {
                return detailImage;
            }

            public void setDetailImage(String detailImage) {
                this.detailImage = detailImage;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public Object getDetailVideo() {
                return detailVideo;
            }

            public void setDetailVideo(Object detailVideo) {
                this.detailVideo = detailVideo;
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

            public Object getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(Object deletedAt) {
                this.deletedAt = deletedAt;
            }

        }

        public class FacebookLink {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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

        public class TwitterLink {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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

        public class InstaLink {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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

        public class YoutubeLink {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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

        public class LinkedinLink {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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

        public class PinterestLink {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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

        public class ReferAndEarn {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("heading")
            @Expose
            private String heading;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private Object description;
            @SerializedName("images")
            @Expose
            private String images;
            @SerializedName("categories_ids")
            @Expose
            private Object categoriesIds;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getHeading() {
                return heading;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public Object getCategoriesIds() {
                return categoriesIds;
            }

            public void setCategoriesIds(Object categoriesIds) {
                this.categoriesIds = categoriesIds;
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

        public class SubCategory {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("category_id")
            @Expose
            private String categoryId;
            @SerializedName("sub_category_icon")
            @Expose
            private String subCategoryIcon;
            @SerializedName("background_image")
            @Expose
            private String backgroundImage;
            @SerializedName("sub_category_name")
            @Expose
            private String subCategoryName;
            @SerializedName("sub_category_slug")
            @Expose
            private String subCategorySlug;
            @SerializedName("short_description")
            @Expose
            private String shortDescription;
            @SerializedName("features")
            @Expose
            private String features;
            @SerializedName("meta_title")
            @Expose
            private String metaTitle;
            @SerializedName("meta_description")
            @Expose
            private String metaDescription;





            @SerializedName("detail_image")
            @Expose
            private String detail_image;

            @SerializedName("meta_keyword")
            @Expose
            private String metaKeyword;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("eligiable_for_all")
            @Expose
            private String eligiableForAll;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("servicable_pincode")
            @Expose
            private String servicablePincode;
            @SerializedName("deleted_at")
            @Expose
            private Object deletedAt;

            public String getDetail_image() {
                return detail_image;
            }

            public void setDetail_image(String detail_image) {
                this.detail_image = detail_image;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public String getSubCategoryIcon() {
                return subCategoryIcon;
            }

            public void setSubCategoryIcon(String subCategoryIcon) {
                this.subCategoryIcon = subCategoryIcon;
            }

            public String getBackgroundImage() {
                return backgroundImage;
            }

            public void setBackgroundImage(String backgroundImage) {
                this.backgroundImage = backgroundImage;
            }

            public String getSubCategoryName() {
                return subCategoryName;
            }

            public void setSubCategoryName(String subCategoryName) {
                this.subCategoryName = subCategoryName;
            }

            public String getSubCategorySlug() {
                return subCategorySlug;
            }

            public void setSubCategorySlug(String subCategorySlug) {
                this.subCategorySlug = subCategorySlug;
            }

            public String getShortDescription() {
                return shortDescription;
            }

            public void setShortDescription(String shortDescription) {
                this.shortDescription = shortDescription;
            }

            public String getFeatures() {
                return features;
            }

            public void setFeatures(String features) {
                this.features = features;
            }

            public String getMetaTitle() {
                return metaTitle;
            }

            public void setMetaTitle(String metaTitle) {
                this.metaTitle = metaTitle;
            }

            public String getMetaDescription() {
                return metaDescription;
            }

            public void setMetaDescription(String metaDescription) {
                this.metaDescription = metaDescription;
            }

            public String getMetaKeyword() {
                return metaKeyword;
            }

            public void setMetaKeyword(String metaKeyword) {
                this.metaKeyword = metaKeyword;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getEligiableForAll() {
                return eligiableForAll;
            }

            public void setEligiableForAll(String eligiableForAll) {
                this.eligiableForAll = eligiableForAll;
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

            public String getServicablePincode() {
                return servicablePincode;
            }

            public void setServicablePincode(String servicablePincode) {
                this.servicablePincode = servicablePincode;
            }

            public Object getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(Object deletedAt) {
                this.deletedAt = deletedAt;
            }

        }
    }
}