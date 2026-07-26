package service;

import model.ItemDetails;

public interface ItemDetailsService {
	
    boolean addItemDetails(ItemDetails itemDetails);

    boolean updateItemDetails(ItemDetails itemDetails);
    
    boolean removeItemDetailsByItemId(int itemId);

    ItemDetails getItemDetailsByItemId(int itemId);
	
}
