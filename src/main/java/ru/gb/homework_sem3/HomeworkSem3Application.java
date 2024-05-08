package ru.gb.homework_sem3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeworkSem3Application {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkSem3Application.class, args);
	}

	/* 
	Для теcтирования проекта использовали программу PostMan:
	a) Добавление пользователя - запрос :
		метод - POST	*body	*raw 
		адрес - http://localhost:8080/users/body
		тело -	{
				"name": "Artur",
				"age": 25,
				"email": "example@mail.ru"
				}
				--------------------------------
				{
				"name": "Boris",
				"age": 55,
				"email": "BorisRaizer@mail.ru"
				}
				--------------------------------
				{
				"name": "Tommy",
				"age": 35,
				"email": "Tom@mail.ru"
				}

	b) Получение списка пользователей на сервере - запрос:
		метод - GET
		адрес - http://localhost:8080/users
		------------------------------------
			[
				{
					"name": "Artur",
					"age": 25,
					"email": "example@mail.ru"
				},
				{
					"name": "Boris",
					"age": 55,
					"email": "BorisRaizer@mail.ru"
				},
				{
					"name": "Tommy",
					"age": 35,
					"email": "Tom@mail.ru"
				}
			]

	c) Проверка сортировки - запрос:
		метод - GET
		адрес - http://localhost:8080/sort
		----------------------------------
			[
				{
					"name": "Artur",
					"age": 25,
					"email": "example@mail.ru"
				},
				{
					"name": "Tommy",
					"age": 35,
					"email": "Tom@mail.ru"
				},
				{
					"name": "Boris",
					"age": 55,
					"email": "BorisRaizer@mail.ru"
				}
			]

	d) Проверка фильтрации - запрос:
		метод - GET
		адрес - http://localhost:8080/filter/25
		---------------------------------------------
			[
				{
					"name": "Boris",
					"age": 55,
					"email": "BorisRaizer@mail.ru"
				},
				{
					"name": "Tommy",
					"age": 35,
					"email": "Tom@mail.ru"
				}
			]

	e) Проверка среднего арифметического - запрос:
		метод - GET
		адрес - http://localhost:8080/calc
		----------------------------------------
				38.333333333333336

	*/
	
}
