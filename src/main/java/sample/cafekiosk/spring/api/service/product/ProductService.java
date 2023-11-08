package sample.cafekiosk.spring.api.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.api.controller.product.dto.request.ProductCreateRequest;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductRepository;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.response.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    // 동시성 이슈
    public ProductResponse createProduct(ProductCreateRequest request) {
        String nextProductNumber = createNextProductNumber();

        return ProductResponse.builder()
            .productNumber(nextProductNumber)
            .type(request.getType())
            .sellingStatus(request.getSellingStatus())
            .name(request.getName())
            .price(request.getPrice())
            .build();
    }

    private String createNextProductNumber() {
        String latestProductNumber = productRepository.findLatestProductNumber();
        if(latestProductNumber == null) {
            return "001";
        }

        int latestProductNumberInt = Integer.parseInt(latestProductNumber);
        int nextProductNumberInt = latestProductNumberInt + 1;

        return String.format("%03d", nextProductNumberInt);

    }

    public List<ProductResponse> getSellingProducts() {

        final List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        return products.stream()
            .map(ProductResponse::of)
            .collect(Collectors.toList());

    }

}
