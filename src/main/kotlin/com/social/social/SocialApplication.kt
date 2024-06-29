package com.social.social

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class SocialApplication

fun main(args: Array<String>) {
	runApplication<SocialApplication>(*args)
}
