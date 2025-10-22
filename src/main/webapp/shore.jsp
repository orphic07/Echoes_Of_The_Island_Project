<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shore — The Lost Island</title>
    <style>
        body {
            font-family: "Georgia", serif;
            background: radial-gradient(circle at center, #2b2b2b 0%, #111 100%);
            color: #dcdcdc;
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
            margin-bottom: 1.5em;
            color: #a1a1a1;
            opacity: 0.7;
            text-align: center;
        }

        p {
            width: 65%;
            margin-bottom: 2em;
            font-size: 1.2em;
            line-height: 1.7em;
            text-indent: 1.5em;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 1em;
            margin-bottom: 4em;
        }

        button {
            background-color: #1e1e1e;
            color: #ddd;
            border: 1px solid #555;
            padding: 0.9em 1.3em;
            border-radius: 6px;
            cursor: pointer;
            font-size: 1em;
            transition: all 0.3s ease;
        }

        button:hover {
            background-color: #3a3a3a;
            border-color: #888;
            color: #fff;
        }
    </style>
</head>
<body>

    <h1>${player.currentState.id}</h1>

    <p>
        The world comes back in fragments — the hiss of dying waves, the grit of sand between your teeth, the weight of your own breath.

        You open your eyes to a gray horizon. The sea is still. The storm has passed, but its memory lingers in the air — heavy, electric.

        Sam is beside you, coughing up salt water. He looks as dazed as you feel, bruised but alive.

        The beach stretches in both directions, quiet and unfamiliar. The sand is darker than it should be — almost ashen. Farther inland, the outline of strange vegetation rises against the fading sky.

        The air is cold. Every muscle aches. There’s no wreckage of the boat, no sound of gulls, no sign of life at all.

        Sam’s voice cuts through the silence. “We have to do something, this place isn´t normal”, he mutters, his eyes scanning the mist.

        You can feel the chill deep in your bones. You’ll need warmth soon… and food. But daylight is fading fast.
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

