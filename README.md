# jetlore-decorator

## Test

```bash
./gradlew check
```

## Extend decorator

```com.jetlore.decorator.RangeItem``` is the interface class between 2nd module output and 3rd decoration module input.
To add new decorator it's required to extend ```com.jetlore.decorator.RangeDecorator``` and add specific entry for 
a new type in decoratorMap inside ```com.jetlore.decorator``` package object.
