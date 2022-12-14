package com.popov.action;

import com.popov.model.ElectricEngine;
import com.popov.model.Engine;

import java.util.Optional;
import java.util.Random;

public class OptionalAction implements Action {
    private static final Random RANDOM = new Random();

    @Override
    public void execute() {
        final Optional<Engine> engineEmptyOptional = CAR_SERVICE.createEngine("werweftg");
        final Optional<Engine> enginePresentOptional = CAR_SERVICE.createEngine("oil");
//        myGetAndIsPresent(engineEmptyOptional);
//        myGetAndIsPresent(enginePresentOptional);

//        myIfPresent(engineEmptyOptional);
//        myIfPresent(enginePresentOptional);

//        myOrElse(engineEmptyOptional);
//        myOrElse(enginePresentOptional);

//        try {
//            myOrElseThrow(engineEmptyOptional);
//        } catch (IllegalAccessError e) {
//            e.printStackTrace();
//        }
//        myOrElseThrow(enginePresentOptional);

//        myOrElseGet(engineEmptyOptional);
//        myOrElseGet(enginePresentOptional);

//        myMap(engineEmptyOptional);
//        myMap(enginePresentOptional);

//        myFilter(engineEmptyOptional);
//        myFilter(enginePresentOptional);
//        enginePresentOptional.ifPresent(engine -> ((OilEngine) engine).setPower(0));
//        myFilter(enginePresentOptional);

//        myIfPresentOrElse(engineEmptyOptional);
//        myIfPresentOrElse(enginePresentOptional);

//        myOr(engineEmptyOptional);
//        myOr(enginePresentOptional);

        inputCanBeNull(null);
        inputCanBeNull("test");
    }

    private Optional<Engine> randomOptional() {
        final int count = RANDOM.nextInt(10);
        if (count <= 3) {
            return Optional.empty();
        } else if (count <= 7) {
//            Optional.of(null); NullPointerException
            return Optional.of(new ElectricEngine());
        } else {
            final Engine engine = null;
            final Optional<Engine> example = engine == null
                    ? Optional.empty() : Optional.of(engine);

            return Optional.ofNullable(engine);
        }
    }

    private void myGetAndIsPresent(final Optional<Engine> engineOptional) {
        if (engineOptional.isPresent()) {
            final Engine engine = engineOptional.get();
            System.out.println("Engine " + engine);
        } else {
            System.out.println("Optional is empty");
        }
    }

    private void myIfPresent(final Optional<Engine> engineOptional) {
        engineOptional.ifPresent(engine -> {
            System.out.println("Engine " + engine);
        });
    }

    private void myOrElse(final Optional<Engine> engineOptional) {
        final Engine engine = engineOptional.orElse(new ElectricEngine());
        System.out.println("Engine " + engine);
    }

    private void myOrElseThrow(final Optional<Engine> engineOptional) {
        final Engine engine = engineOptional.orElseThrow(IllegalAccessError::new);
        System.out.println("Engine " + engine);
    }

    private void myOrElseGet(final Optional<Engine> engineOptional) {
        final Engine engine = engineOptional.orElseGet(() -> {
            return CAR_SERVICE.createDefaultEngine();
        });
        System.out.println("Engine " + engine);
    }

    private void myMap(final Optional<Engine> engineOptional) {
        engineOptional
                .map(e -> {
                    System.out.println("Change type from Engine to String");
                    return e.getType();
                })
                .ifPresent(type -> {
                    System.out.println("Engine type " + type);
                });

    }

    private void myFilter(final Optional<Engine> engineOptional) {
        engineOptional
                .filter(e -> {
                    final boolean b = e.calculatePower() != 0;
                    System.out.println("Check power " + b);
                    return b;
                })
                .ifPresent(engine -> {
                    System.out.println("Engine type " + engine);
                });

    }

    private void myIfPresentOrElse(final Optional<Engine> engineOptional) {
        engineOptional.ifPresentOrElse(
                engine -> {
                    System.out.println("Engine " + engine);
                },
                () -> {
                    final Engine defaultEngine = CAR_SERVICE.createDefaultEngine();
                    System.out.println("Default engine " + defaultEngine);
                }
        );
    }

    private void myOr(final Optional<Engine> engineOptional) {
        final Optional<Engine> engineOptionalNew = engineOptional
                .or(() -> CAR_SERVICE.createEngine("oil"));
        myIfPresent(engineOptionalNew);
    }

    private void inputCanBeNull(final String one) {
        if (one != null) {
            final String s = one.toUpperCase();
            System.out.println(s);
        }

        Optional.ofNullable(one)
                .map(s -> {
                    return s.toUpperCase();
                })
                .ifPresent(s -> {
                    System.out.println(s);
                });
    }
}
