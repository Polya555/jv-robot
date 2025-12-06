package core.basesyntax;

public class RobotRoute {
    public void moveRobot(Robot robot, int toX, int toY) {
        Direction needX = null;
        Direction needY = null;
        if (toX > robot.getX()) {
            needX = Direction.RIGHT;
        } else if (toX < robot.getX()) {
            needX = Direction.LEFT;
        }
        if (toY > robot.getY()) {
            needY = Direction.UP;
        } else if (toY < robot.getY()) {
            needY = Direction.DOWN;
        }

        if (needX != null) {
            int countX = Math.abs(toX - robot.getX());
            turnTo(robot, needX);
            for (int i = 0; i < countX; i++) {
                robot.stepForward();
            }
        }

        if (needY != null) {
            int countY = Math.abs(toY - robot.getY());
            turnTo(robot, needY);
            for (int i = 0; i < countY; i++) {
                robot.stepForward();
            }
        }
    }

    private void turnTo(Robot robot, Direction needed) {
        Direction current = robot.getDirection();
        while (current != needed) {
            current = robot.getDirection();
            if (current == needed) {
                return;
            }
        }
        if (stepForward(current, needed)) {
            robot.turnRight();
        } else {
            robot.turnLeft();
        }
    }

    private boolean stepForward(Direction current, Direction needed) {
        if (current == Direction.UP) {
            return needed == Direction.RIGHT;
        } else if (current == Direction.RIGHT) {
            return needed == Direction.DOWN;
        } else if (current == Direction.DOWN) {
            return needed == Direction.LEFT;
        } else if (current == Direction.LEFT) {
            return needed == Direction.UP;
        }
        return false;
    }
}
