package com.TaskManager.TaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.TaskManager.TaskManager.Principal.MenuUsuario;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner{

	public static void main(String[] args) {

		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Autowired
    private MenuUsuario menuUsuario;
	@Override
	public void run(String... args) throws Exception {

		menuUsuario.menuUser();
	}
}
