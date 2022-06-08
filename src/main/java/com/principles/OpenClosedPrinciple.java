package com.principles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

enum COLOR {
    BLUE, BLACK, GREEN
}
enum SIZE {
    SMALL, MEDIUM, LARGE, EXTRA_LARGE
}

class Product {
    private String name;
    private COLOR color;
    private SIZE size;

    public Product(String name, COLOR color, SIZE size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public COLOR getColor() {
        return color;
    }

    public SIZE getSize() {
        return size;
    }
}

interface Specification<T> {
    public boolean isSatisfy(T item);
}

interface Filter<T> {
    public Stream<T> filter(List<T> items,Specification<T> spec);
}

class ColorSpecification implements Specification<Product> {

    private COLOR color;

    public ColorSpecification(COLOR color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfy(Product item) {
        return this.color == item.getColor();
    }
}

class AndSpecification<T> implements Specification<T> {

    private Specification<T> spec1, spec2;

    public AndSpecification(Specification<T> spec1, Specification<T> spec2) {
        this.spec1 = spec1;
        this.spec2 = spec2;
    }

    @Override
    public boolean isSatisfy(T item) {
        return spec1.isSatisfy(item) && spec2.isSatisfy(item);
    }
}

class SizeSpecification implements Specification<Product> {

    private SIZE size;

    public SizeSpecification(SIZE size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfy(Product item) {
        return this.size == item.getSize();
    }
}

class ProductFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(item -> spec.isSatisfy(item));
    }
}

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("House", COLOR.BLUE, SIZE.LARGE));
        products.add(new Product("Tree", COLOR.GREEN, SIZE.LARGE));
        products.add(new Product("Dog", COLOR.BLACK, SIZE.SMALL));

        ProductFilter pf = new ProductFilter();
        System.out.println("Green Products : ");
        pf.filter(products,new ColorSpecification(COLOR.GREEN)).
                forEach(p -> System.out.println(p.getName() + " Is Green"));

        System.out.println("Large Products : ");
        pf.filter(products,new SizeSpecification(SIZE.LARGE)).
                forEach(p -> System.out.println(p.getName() + " Is Large"));

        System.out.println("Green and Large Products : ");
        pf.filter(products,new AndSpecification<>(new SizeSpecification(SIZE.LARGE),new ColorSpecification(COLOR.GREEN))).
                forEach(p -> System.out.println(p.getName() + " Is Large And Green"));
    }
}
