package in.capace.microservices.inventoryservice.service;

import in.capace.microservices.inventoryservice.model.Inventory;
import in.capace.microservices.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<Inventory> isInStock(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes);
    }
}
