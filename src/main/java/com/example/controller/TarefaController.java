package com.example.controller;

import com.example.entities.Tarefa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    @PostMapping("/criar")
    public Tarefa criarTarefa(@RequestBody Tarefa novaTarefa) {
        novaTarefa.setId(proximoId++);
        tarefas.add(novaTarefa);
        return novaTarefa;
    }

    @GetMapping("/listar")
    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefaPorId(@PathVariable int id) {
        return tarefas.stream()
                .filter(tarefa -> tarefa.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable int id, @RequestBody Tarefa tarefaAtualizada) {
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).getId() == id) {
                tarefaAtualizada.setId(id);
                tarefas.set(i, tarefaAtualizada);
                return tarefaAtualizada;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable int id) {
        tarefas.removeIf(tarefa -> tarefa.getId() == id);
    }
}
