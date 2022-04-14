package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CartRequest implements Serializable  {

    @SerializedName("package_id")
    @Expose
    public String packageId;
    @SerializedName("pack_quantity")
    @Expose
    public String packQuantity;
    @SerializedName("addon_services")
    @Expose
    public List<AddonService> addonServices = null;

    public CartRequest(String packageId, String packQuantity, List<AddonService> addonServices) {
        this.packageId = packageId;
        this.packQuantity = packQuantity;
        this.addonServices = addonServices;
    }


    public static class AddonService implements Serializable {

        @SerializedName("service_id")
        @Expose
        public String serviceId;
        @SerializedName("quantity")
        @Expose
        public String quantity;

        public AddonService(String serviceId, String quantity) {
            this.serviceId = serviceId;
            this.quantity = quantity;
        }


    }

}