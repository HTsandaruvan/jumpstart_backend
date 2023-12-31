package com.lithan.jumpstart.service;

import com.lithan.jumpstart.entity.Category;
import com.lithan.jumpstart.entity.Product;
import com.lithan.jumpstart.payload.request.ProductRequest;
import com.lithan.jumpstart.payload.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    void checkUserIsAdmin(String currentUserEmail);
    BaseResponse<?> saveProduct(String currentUserEmail, MultipartFile image, ProductRequest productRequest);
    Product mapProductRequestToNewProduct(ProductRequest productRequest);
    void mapProductRequestToExistingProduct(ProductRequest productRequest, Product existingProduct);
    BaseResponse<?> showAllProducts();
    BaseResponse<?> showProductDetailsByProductId(Long productId);
    BaseResponse<?> showProductDetailsBySlug(String slug);
    Product getProductDetailsBySlug(String slug);
    String handleUniqueSlug(Product product, String slug);
    BaseResponse<?> deleteProductByProductId(String currentUserEmail, Long productId);
    BaseResponse<?> searchForProducts(String categorySlug, String query);
    List<Product> searchByCategorySlug(String categorySlug);
    List<Product> searchByQuery(String query);
    List<Product> searchByCategorySlugAndQuery(String categorySlug, String query);
}
