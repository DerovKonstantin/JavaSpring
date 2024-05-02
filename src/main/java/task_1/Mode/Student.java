package task_1.Mode;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/** 
 * Класс студент, наследник класса человек
 * @author --
 * @version 1.0
*/
public class Student extends Person implements Comparable<Student> {
    /** поле идентификатор */
    private int id;

    /**
     * Конструктор - создание нового объекта (человек)
     * @param firstName - имя человека
     * @param lastNam - имя фамилия
     * @param age - возраст человека
     * @param id - идентификатор
     */
    public Student(String firstName, String lastNam, int age, int id) {
        super(firstName, lastNam, age);
        this.id = id;
    }

    /**
     * Получения значения поля идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Определение значения поля идентификатор
     * @param id - поле идентификатор
     */
    public void setId(int id) {
        this.id = id;
    }

    // @Override  // Станартный
    // public String toString() {
    //     return String.format("Person [ firstName = %s, lastName = %s, age = %d, id = %d ]", super.getFirstName(), super.getLastName(), super.getAge(), id).toString();
    // }

    @Override // Библиотека apache-commons-lang
    public String toString() { 
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE) // изменили стиль текста с помощью настроек
                .append(super.getFirstName())
                .append(super.getLastName())
                .append(super.getAge())
                .append(id)
                .toString();
    }

    @Override // Библиотека apache-commons-lang
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student person)) return false;
        return new EqualsBuilder()
                .append(super.getFirstName(), person.getFirstName())
                .append(super.getLastName(), person.getLastName())
                .append(super.getAge(), person.getAge())
                .append(id, person.getId())
                .isEquals();
    }

    @Override // Библиотека apache-commons-lang
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(super.getFirstName())
                .append(super.getLastName())
                .append(super.getAge())
                .append(id)
                .toHashCode();
    }

    @Override
    public int compareTo(Student o) {

        // System.out.println(String.format("Compare students [ %s - %s ]", super.getFirstName(), o.getFirstName()));
        if (super.getAge() == o.getAge()) {
            if (id == o.id) return 0;
            if (id > o.id) return 1;
            else return -1;
        }

        if(super.getAge() > o.getAge()) return 1;
        else return -1;        
    }
    
}
