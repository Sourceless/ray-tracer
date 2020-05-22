Feature: Tuples
  Scenario: A tuple with w=1.0 is a point
    Given a <- tuple(4.3, -4.2, 3.1, 1.0)
    Then a.x = 4.3
      And a.y = -4.2
      And a.z = 3.1
      And a.w = 1.0
      And a is a point
      And a is not a vector

  Scenario: A tuple with w=0.0 is a vector
    Given a <- tuple(4.3, -4.2, 3.1, 0.0)
    Then a.x = 4.3
      And a.y = -4.2
      And a.z = 3.1
      And a.w = 0.0
      And a is not a point
      And a is a vector

  Scenario: point() creates tuples with w=1.0
    Given p <- point(4.0, -4.0, 3.0)
    Then p = tuple(4.0, -4.0, 3.0, 1.0)

  Scenario: vector() creates tuples with w=0.0
    Given v <- vector(4.0, -4.0, 3.0)
    Then v = tuple(4.0, -4.0, 3.0, 0.0)

  Scenario: tuple equality
    Given t1 <- tuple(1.0, 2.0, 3.0, 0.0)
      And t2 <- tuple(1.0, 2.0, 3.0, 0.0)
    Then t1 = t2

  Scenario: tuple inequality
    Given t1 <- tuple(1.0, 2.0, 3.0, 0.0)
      And t2 <- tuple(1.0, 1.0, 3.0, 0.0)
    Then t1 != t2

  Scenario: adding two tuples
    Given t1 <- tuple(3.0, -2.0, 5.0, 1.0)
      And t2 <- tuple(-2.0, 3.0, 1.0, 0.0)
    Then t1 + t2 = tuple(1.0, 1.0, 6.0, 1.0)