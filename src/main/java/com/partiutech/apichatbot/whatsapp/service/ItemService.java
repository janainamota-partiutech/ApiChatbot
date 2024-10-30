package com.partiutech.apichatbot.whatsapp.service;

import com.partiutech.apichatbot.whatsapp.dto.ItemDTO;
import com.partiutech.apichatbot.whatsapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Cria um novo item
    public ItemDTO criar(ItemDTO itemDTO) {
        return itemRepository.save(itemDTO);
    }

    public ItemDTO atualizar(Long id, ItemDTO itemDTO) {
        Optional<ItemDTO> itemExistente = itemRepository.findById(id);

        if (itemExistente.isPresent()) {
            ItemDTO itemAtualizado = itemExistente.get();
            itemAtualizado.setNome(itemDTO.getNome());
            itemAtualizado.setDescricao(itemDTO.getDescricao());
            itemAtualizado.setValor(itemDTO.getValor());
            return itemRepository.save(itemAtualizado);
        }

        throw new RuntimeException("Item com ID " + id + " não encontrado.");
    }

    // Busca todos os itens
    public List<ItemDTO> getAll() {
        return itemRepository.findAll();
    }

    // Busca um item pelo ID
    public ItemDTO getById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item com ID " + id + " não encontrado."));
    }

    // Deleta um item pelo ID
    public void delete(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else {
            throw new RuntimeException("Item com ID " + id + " não encontrado.");
        }
    }

}
