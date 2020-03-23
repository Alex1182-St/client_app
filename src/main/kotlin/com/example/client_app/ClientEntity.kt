package com.example.client_app

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "clients")
data class ClientEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(updatable = false, nullable = false)
        val id: UUID? = null,

        @Column(unique = true, nullable = false)
        val clientCredenticals: String = "",

        @Column(unique = true, nullable = false)
        val clientIdentificationCode: Long = 0,

        @Column(unique = true, nullable = false)
        val clientEmail: String = "",

        @Column(unique = true, nullable = false)
        val clientPhoneNumber: String = ""

        )