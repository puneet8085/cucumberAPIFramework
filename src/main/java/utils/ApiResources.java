package utils;

public enum ApiResources {

    deletePlaceApi("/maps/api/place/delete/json"),
    getPlaceApi("/maps/api/place/get/json"),
    addPlaceApi("/maps/api/place/add/json");

    private String resource;
    ApiResources(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}
