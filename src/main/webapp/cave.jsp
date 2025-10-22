<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>The Cave — The Lost Island</title>
    <style>
        body {
            font-family: "Georgia", serif;
            background:  radial-gradient(circle at center, #1a1a1a 0%, #000000 100%);
            color: #d8d8d8;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            text-align: center;
            padding: 2em;
            overflow-y: auto;
        }

        h1 {
            font-size: 2.4em;
            margin-bottom: 2em;
            color: #a39bff;
            opacity: 0.7;
            text-align: center;
        }

        p {
            width: 65%;
            margin-bottom: 2em;
            font-size: 1.2em;
            line-height: 1.7em;
            text-indent: 1.5em;
            color: #e8e8dc;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 1em;
            margin-bottom: 4em;
        }

        button {
            background-color: #262440;
            color: #e3e3ff;
            border: 1px solid #6256ff;
            padding: 0.8em 1.2em;
            border-radius: 7px;
            cursor: pointer;
            font-size: 1em;
            transition: all 0.3s ease;
        }

        button:hover {
            background-color: #3a36a0;
            border-color: #9a8fff;
            color: #fff;
        }
    </style>
</head>
<body>

    <h1>${player.currentState.id}</h1>

    <p>

        The jungle had given little, but not nothing. You and Sam carry a few pieces of driftwood, some torn cloth,

        and a handful of strange fruit that oozes a faint blue light — enough to keep you alive for now.

        The path leads into a gaping cave, its entrance breathing cold air thick with damp and silence.

        The faint sound of dripping water echoes endlessly through the dark.

        Strange carvings shimmer faintly on the walls — symbols that twist in the light of your lantern, shifting when you blink.

        Sam runs his hand over one of them. “Someone’s been here before,” he whispers. “But… when?”

        You both exchange a glance. The air hums with an energy neither of you can explain — as if the island itself is awake and listening.

        The deeper tunnels seem to pull you in, while the shadows near the entrance whisper safety. You need to decide.
    </p>

    <form action="game" method="post">
        <c:forEach var="entry" items="${player.currentState.choices}">
            <button type="submit" name="choice" value="${entry.key}">
                ${entry.value.text}
            </button>
        </c:forEach>
    </form>

</body>
</html>


