/*
 * package com.sai.dao;
 * 
 * import java.util.ArrayList; import java.util.Arrays; import java.util.List;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.PersistenceContext; import javax.persistence.Query;
 * 
 * import org.springframework.stereotype.Repository;
 * 
 * import com.sai.entity.DishEntity; import com.sai.entity.RestaurantEntity;
 * import com.sai.model.Dish; import com.sai.model.Restaurant; import
 * com.sai.model.RestaurantTransaction;
 * 
 * @Repository(value = "searchDAO") public class SearchDAOImpl implements
 * SearchDAO {
 * 
 * @PersistenceContext private EntityManager entityManager;
 * 
 * 
 * @Override public List<Restaurant> viewAllRestaurants() {
 * 
 * List<Restaurant> restaurants = new ArrayList<>();
 * System.out.println("Hello"); Query query =
 * entityManager.createQuery("select re from RestaurantEntity re");
 * System.out.println("Hello2"); List<RestaurantEntity> restaurantEntities =
 * query.getResultList(); if (restaurantEntities != null &&
 * !restaurantEntities.isEmpty()) { for (RestaurantEntity re :
 * restaurantEntities) { Restaurant r = new Restaurant();
 * r.setRestaurantId(re.getRestaurantId());
 * r.setRestaurantName(re.getRestaurantName());
 * r.setRestaurantContact(re.getRestaurantContact());
 * r.setRestaurantType(re.getRestaurantType());
 * r.setAddressLine1(re.getAddressLine1()); r.setArea(re.getArea());
 * r.setCity(re.getCity()); r.setResState(re.getResState());
 * r.setPincode(re.getPincode()); r.setApprovalStatus(re.getApprovalStatus());
 * r.setAvgRating(re.getAvgRating()); String[]
 * photos=re.getPhotoUrls().split("-"); r.setPhotoUrls(Arrays.asList(photos));
 * if(!re.getDishes().isEmpty()) { List<Dish> dishList=new ArrayList<>();
 * for(DishEntity de:re.getDishes()) { Dish d=new Dish();
 * d.setDishId(de.getDishId()); d.setDishName(de.getDishName());
 * d.setDishType(de.getDishType()); d.setDishCuisine(de.getDishCuisine());
 * d.setDishDescription(de.getDishDescription());
 * d.setAvgRating(de.getAvgRating()); d.setPrice(de.getPrice());
 * d.setSpeciality(de.getSpeciality()); d.setImageUrl(de.getImageUrl());
 * dishList.add(d); } r.setDishes(dishList); } if(re.getTransaction()!=null) {
 * RestaurantTransaction rt=new RestaurantTransaction();
 * rt.setRestaurantTransactionId(re.getTransaction().getRestaurantTransactionId(
 * )); rt.setRestaurantStatus(re.getTransaction().getRestaurantStatus());
 * rt.setRestaurantApproxCost(re.getTransaction().getRestaurantApproxCost());
 * rt.setRestaurantOrderCounter(re.getTransaction().getRestaurantOrderCounter())
 * ; r.setTransaction(rt); } restaurants.add(r); } } return restaurants; }
 * 
 * }
 */