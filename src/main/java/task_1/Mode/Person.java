package task_1.Mode;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/** 
 * Абстрактный класс человек
 * @author --
 * @version 1.0
*/
public abstract class Person implements Serializable {
    /** поле имя */
    private String firstName;
    /** поле фамилия */
    private String lastName;
    /** поле возраст */
    private int age;
    
    /**
     * Конструктор - создание нового объекта (человек)
     * @param firstName - имя человека
     * @param lastNam - имя фамилия
     * @param age - возраст человека
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Получение значения поля имя человека
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Определения значения поля имя человека
     * @param name - поле имя человека
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Получение значения поля фамилия человека
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Определения значения поля фамилия человека
     * @param lastName - поле фамилия человека
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Получение значения поля возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * Определение значения поля возраст
     * @param age - поле возраст
     */
    public void setAge(int age) {
        this.age = age;
    }

    // @Override // Станартный
    // public String toString() {
    //     return String.format("Person [ firstName = %s, lastName = %s, age = %d ]", firstName, lastName, age);
    // }

    @Override // Библиотека apache-commons-lang
    public String toString() { 
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE) // изменили стиль текста с помощью настроек
                .append(firstName)
                .append(lastName)
                .append(age)
                .toString();
    }

    @Override // Библиотека apache-commons-lang
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return new EqualsBuilder()
                .append(firstName, person.getFirstName())
                .append(lastName, person.getLastName())
                .append(age, person.getAge())
                .isEquals();
    }

    @Override // Библиотека apache-commons-lang
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(lastName)
                .append(age)
                .toHashCode();
    }
}
