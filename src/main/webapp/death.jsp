<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>You Died — The Lost Island</title>
    <style>
        body {
            background-color: #000;
            color: #e2e2e2;
            font-family: "Georgia", serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            text-align: center;
            overflow: hidden;
        }

        h1 {
            font-size: 3em;
            color: crimson;
            opacity: 0;
            transition: opacity 2s ease;
        }

        p {
            max-width: 70%;
            font-size: 1.2em;
            line-height: 1.6;
            opacity: 0;
            transition: opacity 2s ease;
        }

        form {
            opacity: 0;
            transition: opacity 2s ease;
        }

        button {
            background-color: #111;
            color: #ddd;
            border: 1px solid #444;
            padding: 0.8em 1.2em;
            border-radius: 6px;
            cursor: pointer;
            font-size: 1em;
            margin-top: 2em;
        }

        button:hover {
            background-color: #333;
            color: #fff;
        }

        .visible {
            opacity: 1;

        }


    </style>
</head>
<body>

    <!-- Fade order: first the title, then the story, then the button -->
    <h1 id="deathTitle">YOU DIED</h1>

    <c:choose>
        <c:when test="${player.lastStateId == 'Shore'}">
            <p id="deathText">
                The night swallowed them whole.<br>
                The fire never caught. The cold bit through skin, bone, and will.<br>
                When dawn came, the island was silent again — two shapes washed still against the blackened sand.
            </p>
        </c:when>

        <c:when test="${player.lastStateId == 'Jungle'}">
            <p id="deathText">
                The scream came closer this time.<br>
                Through the tangled red glow, it emerged — pale, stretched, wrong.<br>
                One hand fused to its face, a single red eye searching through the dark.<br>
                Its teeth glistened like shards of bone as it dragged itself closer.<br>
                When John’s breath finally left him, that eye was the last thing he saw.
            </p>
        </c:when>
    </c:choose>

    <form action="game" method="get" id="retryForm">
        <input type="hidden" name="action" value="restart">
        <button type="submit">Wake Again</button>
    </form>


    <script>
        document.addEventListener("DOMContentLoaded", () => {
            const title = document.getElementById("deathTitle");
            const text = document.getElementById("deathText");
            const form = document.getElementById("retryForm");

            setTimeout(() => title.classList.add("visible"), 500);   // fade in title first
            setTimeout(() => text.classList.add("visible"), 2500);   // then text
            setTimeout(() => form.classList.add("visible"), 5000);   // finally button
        });
    </script>

</body>
</html>
