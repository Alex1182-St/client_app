package com.example.client_app

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface ClientRepository : JpaRepository<ClientEntity, UUID> {

    fun findByClientEmail(clientEmail : String) : ClientEntity

    fun findByClientEmailAndClientCredenticals(clientEmail : String, clientCredenticals : String) : ClientEntity

    fun findByClientEmailOrClientCredenticals(clientEmail : String, clientCredenticals : String) : ClientEntity

}