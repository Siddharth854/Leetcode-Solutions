import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        // Initialize with 1 as a neutral multiplier for easier division
        prefixProducts.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            // A zero invalidates all previous products; reset the list
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int n = prefixProducts.size();
        // If k >= n, it means a zero occurred within the last k elements
        if (k >= n) {
            return 0;
        }
        return prefixProducts.get(n - 1) / prefixProducts.get(n - 1 - k);
    }
}
