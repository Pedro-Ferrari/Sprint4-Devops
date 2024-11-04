package com.analyzer.controller;

import com.analyzer.model.Feedback;
import com.analyzer.model.Usuario;
import com.analyzer.service.FeedbackService;
import com.analyzer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/feedbacks")
    public String listarFeedbacks(Model model) {
        List<Feedback> feedbacks = feedbackService.listarTodos();
        List<Usuario> usuarios = usuarioService.listarTodos();
        model.addAttribute("feedbacks", feedbacks);
        model.addAttribute("usuarios", usuarios);
        return "feedbacks/listar";
    }

    @GetMapping("/feedbacks/novo")
    public String novoFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "feedbacks/novo";
    }

    @PostMapping("/feedbacks")
    public String salvarFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.salvar(feedback);
        return "redirect:/feedbacks";
    }

    @GetMapping("/feedbacks/editar/{id}")
    public String editarFeedbackForm(@PathVariable Long id, Model model) {
        Feedback feedback = feedbackService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("feedback", feedback);
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "feedbacks/editar";
    }

    @PostMapping("/feedbacks/editar/{id}")
    public String atualizarFeedback(@PathVariable Long id, @ModelAttribute Feedback feedback, Model model) {
        try {
            Feedback feedbackExistente = feedbackService.buscarPorId(id)
                    .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

            Usuario usuario = usuarioService.buscarPorId(feedback.getUsuario().getId())
                    .orElseThrow(() -> new IllegalArgumentException("ID de usuário inválido: " + feedback.getUsuario().getId()));

            feedbackExistente.setDescricao(feedback.getDescricao());
            feedbackExistente.setNota(feedback.getNota());
            feedbackExistente.setUsuario(usuario);

            feedbackService.salvar(feedbackExistente);

            return "redirect:/feedbacks";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Erro ao atualizar o feedback: " + e.getMessage());
            return "feedbacks/editar";
        }
    }

    @GetMapping("/feedbacks/deletar/{id}")
    public String deletarFeedback(@PathVariable Long id) {
        feedbackService.deletarPorId(id);
        return "redirect:/feedbacks";
    }
}