Transition between indexes -- size(universe_index) x, cluster_index i, position_in_cluster j (0 <= j < sqrt(u)):
        x = i * sqrt(u) + j
    Hence, helper functions: high(x) = floor(x / sqrt(u)) = i; low(x) = x mod sqrt(u) = j
        -> in bit-wise representation, eg. u = 16 and x = 9, the bit representation of x is 1001, which has exactly the same length of sqrt(u) (4 bits), so 1 0 0 1 -> high(x) = 10, low(x) = 01
                               --- ---
                              high low

1. bit vector = an array of size u (0 = absent; 1 = present)
2. split universe into sqrt(u) clusters of size sqrt(u)
    -- Insert needs O(1)
    -- Successor(x) needs O(sqrt(u)): a. look into x's clusters; b. look for next 1 in the summary; c. look for first 1 in that cluster
3. recurse with V = size-u vEB; V.cluster[i] = size-sqrt(u) vEB (0 <= i < sqrt(u)); V.summary = size-sqrt(u) vEB
    -- Insert(V, x) = Insert(V.cluster(high(x)), low(x)) and Insert(V.summary, high(x))
    -- Successor(x)
4. this

