package com.desafio.contatos.seeders;

import com.desafio.contatos.models.Categoria;
import com.desafio.contatos.models.Contato;
import com.desafio.contatos.models.Grupo;
import com.desafio.contatos.models.Telefone;
import com.desafio.contatos.repositories.CategoriaRepository;
import com.desafio.contatos.repositories.ContatoRepository;
import com.desafio.contatos.repositories.GrupoRepository;
import com.desafio.contatos.repositories.TelefoneRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DatabaseSeeder {

    private Faker faker = new Faker(new Locale("pt-BR"));

    @Autowired
    private ContatoRepository cRepository;
    @Autowired
    private TelefoneRepository tRepository;
    @Autowired
    private CategoriaRepository caRepository;
    @Autowired
    private GrupoRepository gRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        this.truncate();
        this.seedContatos();
        this.seedCategorias();
        this.seedGrupos();
        this.seedTelefones();
    }

    private void truncate() {
        gRepository.deleteAll();
        cRepository.deleteAll();
        caRepository.deleteAll();
        tRepository.deleteAll();
    }

    private void seedContatos() {
        List<Contato> contatos = new ArrayList<>();

        for (int i = 0; i < 50; i ++) {
            Contato c = new Contato();
            c.setNome(faker.name().fullName());
            c.setEmail(faker.internet().emailAddress());
            c.setDataNascimento(new Date());
            contatos.add(c);
        }
        cRepository.saveAll(contatos);
    }

    private void seedCategorias() {
        Categoria c;

        c = new Categoria();
        c.setNome("Residencial");
        caRepository.save(c);

        c = new Categoria();
        c.setNome("Celular");
        caRepository.save(c);

        c = new Categoria();
        c.setNome("Profissional");
        caRepository.save(c);
    }

    private void seedGrupos() {
        Grupo g;

        g = new Grupo();
        g.setNome("Inadimplentes");
        gRepository.save(g);

        g = new Grupo();
        g.setNome("Adimplentes");
        gRepository.save(g);

    }

    private void seedTelefones() {
        Random rand = new Random();
        List<Telefone> telefones = new ArrayList<>();
        cRepository.findAll().forEach(c -> {
            for (int i = 0; i < (rand.nextInt(4) + 1); i ++) {
                Telefone t = new Telefone();
                t.setNumero(faker.phoneNumber().phoneNumber());
                t.setContato(c);
                telefones.add(t);
                c.setTelefones(telefones);
            }
            cRepository.save(c);
            telefones.clear();
        });
    }

}
