package com.example.client_app

import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api")
class ClientController(val clientRepo : ClientRepository) {

    @PostMapping("newClient")
    fun createNewClient(@RequestBody newClient : ClientEntity) : ClientEntity {
        return clientRepo.save(newClient)
    }

    @PostMapping("clientByMail")
    fun clientByMailWithPost(@RequestBody body : Map<String, Any>) : ClientEntity {
        return clientRepo.findByClientEmail(body.get("clientEmail") as String)
    }

    @PostMapping("clientByMailAndCredenticals")
    fun clientByMailAndCredenticalsWithPost(@RequestBody body: Map<String, Any>) : ClientEntity {
        return clientRepo.findByClientEmailAndClientCredenticals(
                body.get("clientEmail") as String,
                body.get("clientCredenticals") as String)
    }

/*
    @PostMapping("clientByMailOrCredenticals")
    fun clientByMailOrCredenticalsWithPost(@RequestBody body: Map<String, Any>) : ClientEntity {
        return clientRepo.findByClientEmailOrClientCredenticals(body.get("clientEmail") as String, body.get("clientCredenticals") as String)
    }
*/

    @GetMapping("clients/byEmail/{clientEmail}")
    fun getClientByEmail(@PathVariable clientEmail : String) : ClientEntity {
        return clientRepo.findByClientEmail(clientEmail)
    }

    @GetMapping("clients")
    fun getAllClients() : List<ClientEntity> {
        return clientRepo.findAll()
    }

    @GetMapping("clients/{id}")
    fun getClientById(@PathVariable id : UUID) : Optional<ClientEntity> {
        return clientRepo.findById(id)
    }

    @PutMapping("clients/{id}")
    fun updateClient(@PathVariable id : UUID, @RequestBody updatedClient : ClientEntity) : ClientEntity {
        return clientRepo.save(updatedClient)
    }

    @DeleteMapping("clients/{id}")
    fun deleteClient(@PathVariable id : UUID) {
        return clientRepo.deleteById(id)
    }

}