package com.juans.echoes.servlet;

import com.juans.echoes.controller.GameEngine;
import com.juans.echoes.model.Player;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GameServlet extends HttpServlet {
    private GameEngine engine;

    @Override
    public void init() throws ServletException {
        engine = new GameEngine();
        engine.initializeGame();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choiceKey = request.getParameter("choice");

        if(choiceKey != null){
            engine.processChoice(choiceKey);
        }

        Player player = engine.getJohn();
        request.setAttribute("player", player);
        request.setAttribute("lastChoice", choiceKey);
        request.setAttribute("stats", engine.getStats());

        String jspName = player.getCurrentState().getId().toLowerCase() + ".jsp";

        System.out.println("DEBUG: Current state -> " + player.getCurrentState().getId());
        System.out.println("DEBUG: Choices -> " + player.getCurrentState().getChoices().size());
        System.out.println("DEBUG: Is end state? -> " + player.getCurrentState().isEndState());
        System.out.println("DEBUG: End type -> " + player.getCurrentState().getEndType());

        request.getRequestDispatcher(jspName).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("restart".equals(action)) {
            engine.restartGame();
            response.sendRedirect("index.jsp");
            return;
        }

        Player player = engine.getJohn();
        request.setAttribute("player", player);
        request.setAttribute("stats", engine.getStats());
        String jspName = player.getCurrentState().getId().toLowerCase() + ".jsp";
        request.getRequestDispatcher(jspName).forward(request, response);

    }

}
