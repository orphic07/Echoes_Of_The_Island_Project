package com.juans.echoes.servlet;

import com.juans.echoes.controller.GameEngine;
import com.juans.echoes.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/play")
public class GameServlet extends HttpServlet {
    private GameEngine engine;

    @Override
    public void init() throws ServletException {
        engine = new GameEngine();
        engine.initializeGame();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choicekey = request.getParameter("choice");

        if(choicekey != null){
            engine.processChoice(choicekey);
        }

        Player player = engine.getJohn();
        request.setAttribute("player", player);

        String jspName = player.getCurrentState().getId().toLowerCase() + ".jsp";

        request.getRequestDispatcher(jspName).forward(request, response);


    }

}
