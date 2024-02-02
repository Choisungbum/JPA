package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address_bk {
    // 값 타입으로 생성시 해당 컬럼 조작하면 편하다
    @Column(length = 10)
    private String city;
    @Column(length = 20)
    private String street;
    @Column(length = 5)
    private String zipcode;

    // validation 이나 필요한 메서드 생성하면 사용하기 편하다 
    private String fullAddress() {
        return getCity()+ " " + getStreet() + " " +getZipcode();
    }



    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }


    private void setCity(String city) {
        this.city = city;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    // equals & hashcode 생성시'Use getters during code generation' 을사용하는 것이 좋다
    // getter로 접근하지 않을경우 해당 값이 프록시 일 때 계산이되지 않음 !!


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address_bk addressBk = (Address_bk) o;
        return Objects.equals(getCity(), addressBk.getCity()) && Objects.equals(getStreet(), addressBk.getStreet()) && Objects.equals(getZipcode(), addressBk.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
