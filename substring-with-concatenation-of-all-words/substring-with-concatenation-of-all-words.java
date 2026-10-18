left += wordLen;
                        count--;
                    }
                    
                    if (count == totalWords) {
                        result.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        
        return result;
    }
}