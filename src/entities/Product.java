package entities;

public class Product {

	public Product() {
	}

	private String productName;
	private Double productPrice;
	private Integer productQuantity;

	public Product(String productName, Double productPrice, Integer productQuantity) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	public String getProductName() {
		return productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	private Double priceOrder() {
		return getProductQuantity() * getProductPrice();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getProductName() + ", ");
		sb.append(String.format("%.2f", priceOrder()));
		return sb.toString();
	}

}
